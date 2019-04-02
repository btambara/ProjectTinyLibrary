import{NgModule}from'@angular/core';
import {Routes, RouterModule}from '@angular/router';
import {TinylibraryComponent}from './tinylibrary/tinylibrary.component';
import { NearbyTinylibraryComponent}from './nearby-tinylibrary/nearby-tinylibrary.component';
import {AddTinylibraryComponent}from './add-tinylibrary/add-tinylibrary.component';

const routes: Routes = [
{path: '', redirectTo: 'nearby', pathMatch: 'full'
},
{
path: 'nearby',
component: NearbyTinylibraryComponent
},
{
path: 'library/:id',
component: TinylibraryComponent
},
{
path: 'add',
component: AddTinylibraryComponent
}
];

@NgModule({
imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
