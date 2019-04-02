import{Component, OnInit, Inject}from '@angular/core';
import {MatTableDataSource, MatDialogRef, MAT_DIALOG_DATA, MatDialog}from '@angular/material';
import {FormGroup, FormBuilder, FormControl, Validators}from '@angular/forms';
import {EditBookComponent}from '../edit-book/edit-book.component';
import { AddBookComponent}from '../add-book/add-book.component';
import {ActivatedRoute, Router }from '@angular/router';
import {TinyLibraryService}from '../tinylibrary.service';
import {Tinylibrary}from '../tinylibrary';
import { Book}from '../book';
@Component({
selector: 'app-add-tinylibrary',
templateUrl: './add-tinylibrary.component.html',
styleUrls: ['./add-tinylibrary.component.css']
})
export class AddTinylibraryComponent implements OnInit {
form: FormGroup;
displayedColumns: string[] = ['quantity', 'title', 'author', 'checkin'];

tinyLib: Tinylibrary;
dataSource: any
editBookDialogRef: MatDialogRef < EditBookComponent>;
addBookDialogRef: MatDialogRef < AddBookComponent>;

constructor(private formBuilder: FormBuilder, public dialog: MatDialog, private router: Router, private tinyLibraryService: TinyLibraryService) {
    this.tinyLib = new Tinylibrary();
  }

  ngOnInit() {
    this.dataSource = new MatTableDataSource(this.tinyLib.books);
    this.form = this.formBuilder.group({
      'name': new FormControl(this.tinyLib.name, [Validators.required, Validators.minLength(1)]),
      'latitude': new FormControl(this.tinyLib.location.coordinates[0], [Validators.required, Validators.pattern("^-?\\d+\\.?\\d*$"), Validators.minLength(1)]),
      'longtitude': new FormControl(this.tinyLib.location.coordinates[1], [Validators.required, Validators.pattern("^-?\\d+\\.?\\d*$"), Validators.minLength(1)]),
    })
  }

  editBook(book: any) {
    this.editBookDialogRef = this.dialog.open(EditBookComponent, {
      width: "65%",
      data: JSON.parse(JSON.stringify(book))    //deep copy
    });

    this.editBookDialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.tinyLib.books[this.tinyLib.books.indexOf(book)] = result;
        this.dataSource = new MatTableDataSource(this.tinyLib.books);
      }
    });
  }

  addBook(): void {
    this.addBookDialogRef = this.dialog.open(AddBookComponent, {
      width: "65%",
      data: {
        quantity: 0,
        type: "",
        title: "",
        authorFirstName: "",
        authorLastName: "",
        summary: ""
      }
    });

    this.addBookDialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.tinyLib.books[this.tinyLib.books.length] = result;
        this.dataSource = new MatTableDataSource(this.tinyLib.books);
      }
    });
  }

  removeBook(book: any) {
    var index = this.tinyLib.books.indexOf(book); //AN ALERT POP UP WOULD BE GREAT FOR THIS
    this.tinyLib.books.splice(index, 1);
    this.dataSource = new MatTableDataSource(this.tinyLib.books);
  }
  gotoNearby() {
    this.router.navigate(['/nearby']);
  }
  addTinyLibrary(form): void {
    this.tinyLib.name = form.value.name.toString().trim();
    this.tinyLib.location.coordinates[0] = form.value.latitude.toString().trim();
    this.tinyLib.location.coordinates[1] = form.value.longtitude.toString().trim();
    this.tinyLibraryService.addTinyLibrary(this.tinyLib);
    this.gotoNearby();
  }
}
