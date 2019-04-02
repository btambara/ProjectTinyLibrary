import{Component, OnInit, Inject}from '@angular/core';
import {MatTableDataSource, MatDialogRef, MAT_DIALOG_DATA }from '@angular/material';
import {FormGroup, FormBuilder, FormControl, Validators} from '@angular/forms';
@Component({
selector: 'app-edit-book',
templateUrl: './edit-book.component.html',
styleUrls: ['./edit-book.component.css']
})
export class EditBookComponent implements OnInit {
form: FormGroup;

constructor(
    @Inject(MAT_DIALOG_DATA) public data: any,
    private formBuilder: FormBuilder,
    private dialogRef: MatDialogRef<EditBookComponent>
  ) { }

  ngOnInit() {
    this.form = this.formBuilder.group({
      'type': new FormControl(this.data.type, [Validators.required, Validators.minLength(1)]),
      'title': new FormControl(this.data.title, [Validators.required, Validators.minLength(1)]),
      'firstName': new FormControl(this.data.authorFirstName, [Validators.required, Validators.minLength(1)]),
      'lastName': new FormControl(this.data.authorLastName, [Validators.required, Validators.minLength(1)]),
      'summary': new FormControl(this.data.summary, [Validators.required, Validators.minLength(1)]),
      'quantity': new FormControl(this.data.quantity, [Validators.required, Validators.pattern("^\\d+$"), Validators.minLength(1)]),
    })
  }

  submit(form) {
    this.data.type = form.value.type.toString().trim();
    this.data.title = form.value.title.toString().trim();
    this.data.authorFirstName = form.value.firstName.toString().trim();
    this.data.authorLastName = form.value.lastName.toString().trim();
    this.data.summary = form.value.summary.toString().trim();
    this.data.quantity = form.value.quantity.toString().trim();

    this.dialogRef.close(this.data);
  }
}
