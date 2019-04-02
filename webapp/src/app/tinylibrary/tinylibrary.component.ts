import{Component, OnDestroy, OnInit}from '@angular/core';
import {Subscription}from 'rxjs';
import {ActivatedRoute, Router}from '@angular/router';
import { TinyLibraryService}from '../tinylibrary.service'
import {CheckinBookComponent}from '../checkin-book/checkin-book.component';
import {MatTableDataSource, MatDialog, MatDialogRef, MatDialogConfig}from '@angular/material';
import { EditTinylibraryComponent}from '../edit-tinylibrary/edit-tinylibrary.component';

@Component({
selector: 'app-tinylibrary',
templateUrl: './tinylibrary.component.html',
styleUrls: ['./tinylibrary.component.css']
})
export class TinylibraryComponent implements OnInit, OnDestroy {
sub: Subscription;
tinyLib: any;
dataSource: any;
displayedColumns: string[] = ['quantity', 'title', 'author', 'summary', 'checkout'];
checkInBookDialogRef: MatDialogRef < CheckinBookComponent>;
editLibraryDialogRef: MatDialogRef < EditTinylibraryComponent>;

constructor(private route: ActivatedRoute,
    private router: Router,
    public dialog: MatDialog,
    private tinyLibraryService: TinyLibraryService) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];

      if (id) {
        this.tinyLibraryService.getTinyLibrary(id).subscribe((tl: any) => {
          if (tl) {
            this.tinyLib = tl;
            this.dataSource = new MatTableDataSource(this.tinyLib.books);
          }
        }, error => console.log(error));
      }
    });
  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();

    // if (this.dataSource.paginator) {
    //   this.dataSource.paginator.firstPage();
    // }
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  gotoNearby() {
    this.router.navigate(['/nearby']);
  }

  isCheckOutDisabled(book: any): boolean {
    return book.quantity == 0;
  }

  delete(id: string) {
    this.tinyLibraryService.deleteTinyLibrary(id).subscribe(result => {
      this.gotoNearby();
    }, error => console.error(error));
  }

  onCheckOut(book: any, id: string): void {
    if ((book.quantity - 1) >= 0) {
      book.quantity = book.quantity - 1;
      this.tinyLibraryService.checkOutBookFromTinyLibrary(book, id);
    } else {
      alert(book.title + " is current not available."); //Should never get here.
    }
  }

  onEditLibraryDialog(): void {
    this.editLibraryDialogRef = this.dialog.open(EditTinylibraryComponent, {
      width: "95%",
      data: JSON.parse(JSON.stringify(this.tinyLib))    //deep copy
    });

    this.editLibraryDialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.tinyLib = result;
        this.dataSource = new MatTableDataSource(this.tinyLib.books);
        this.tinyLibraryService.editTinyLibrary(this.tinyLib);
      }
    });
  }

  onCheckInDialog(): void {
    this.checkInBookDialogRef = this.dialog.open(CheckinBookComponent, {
      width: "95%",
      data: JSON.parse(JSON.stringify(this.tinyLib.books))    //deep copy
    });

    this.checkInBookDialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.tinyLib.books = result;
        this.dataSource = new MatTableDataSource(this.tinyLib.books);
        this.tinyLibraryService.checkInBooksFromTinyLibrary(this.tinyLib.books, this.tinyLib.objectIDHexString);
      }
    });
  }
}
