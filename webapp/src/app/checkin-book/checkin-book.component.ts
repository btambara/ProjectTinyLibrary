import{Component, OnInit, Inject}from '@angular/core';
import {MatTableDataSource, MatDialogRef, MAT_DIALOG_DATA, MatDialog}from '@angular/material';
import {FormGroup, FormBuilder}from '@angular/forms';
import {AddBookComponent }from '../add-book/add-book.component';

@Component({
selector: 'app-checkin-book',
templateUrl: './checkin-book.component.html',
styleUrls: ['./checkin-book.component.css']
})
export class CheckinBookComponent implements OnInit {
form: FormGroup;
displayedColumns: string[] = ['quantity', 'title', 'author', 'checkin'];
dataSource: any;
addBookDialogRef: MatDialogRef < AddBookComponent>;

constructor(
    @Inject(MAT_DIALOG_DATA) public data: any,
    private formBuilder: FormBuilder,
    public dialog: MatDialog,
    private dialogRef: MatDialogRef<CheckinBookComponent>

  ) { }

  ngOnInit() {
    this.dataSource = new MatTableDataSource(this.data);
    this.form = this.formBuilder.group({

    })
  }

  checkInBook(element: any) {
    element.quantity = element.quantity + 1;
  }

  addBook(): void {
    this.addBookDialogRef = this.dialog.open(AddBookComponent, {
      width: "65%",
      data:{
        quantity: 0,
        type: "",
        title: "",
        authorFirstName: "",
        authorLastName: "",
        summary: ""
      }
    });
    
    this.addBookDialogRef.afterClosed().subscribe(result => { //SHOULD BE ABLE TO EDIT THE RECENTLY ADD BOOK
      if (result) {
        this.data[this.data.length] = result;
        this.dataSource = new MatTableDataSource(this.data);
      }
    });
  }

  submit(form) {
    this.dialogRef.close(this.data);
  }
}
