import{BrowserModule}from'@angular/platform-browser';
import {BrowserAnimationsModule }from '@angular/platform-browser/animations'
import {NgModule}from '@angular/core';
import {AppRoutingModule}from './app-routing.module';
import { AppComponent}from './app.component';

import {TinyLibraryService}from './tinylibrary.service'
import {HttpClientModule} from '@angular/common/http';
import {NearbyTinylibraryComponent}from './nearby-tinylibrary/nearby-tinylibrary.component';

import { AgmCoreModule}from '@agm/core';
import {MatSidenavModule, MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule, MatSliderModule, MatTableModule, MatPaginatorModule, MatIconModule, MatDialogModule, MatSidenav}from '@angular/material';
import {FlexLayoutModule} from '@angular/flex-layout';
import {FormsModule, ReactiveFormsModule}from '@angular/forms';
import {ScrollingModule}from '@angular/cdk/scrolling';
import {TinylibraryComponent}from './tinylibrary/tinylibrary.component';
import {CheckinBookComponent}from './checkin-book/checkin-book.component';
import {EditTinylibraryComponent}from './edit-tinylibrary/edit-tinylibrary.component';
import {AddBookComponent }from './add-book/add-book.component';
import {EditBookComponent}from './edit-book/edit-book.component';
import {AddTinylibraryComponent}from './add-tinylibrary/add-tinylibrary.component';

@NgModule({
declarations: [
AppComponent,
NearbyTinylibraryComponent,
TinylibraryComponent,
CheckinBookComponent,
EditTinylibraryComponent,
AddBookComponent,
EditBookComponent,
AddTinylibraryComponent
],
imports: [
BrowserModule,
BrowserAnimationsModule,
ScrollingModule,
FormsModule,
ReactiveFormsModule,
FlexLayoutModule,
HttpClientModule,
AppRoutingModule,
AgmCoreModule.forRoot({
      apiKey: 'AIzaSyDxjaHuQmiWybQ9EpPL_aUxVVwBpOqJTCs'
    }),
    MatButtonModule,
    MatSidenavModule,
    MatDialogModule,
    MatCardModule,
    MatIconModule,
    MatPaginatorModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    MatTableModule,
    MatSliderModule
  ],
  providers: [TinyLibraryService],
  bootstrap: [AppComponent],
  entryComponents: [CheckinBookComponent, EditTinylibraryComponent, EditBookComponent, AddBookComponent]
})
export class AppModule { }
