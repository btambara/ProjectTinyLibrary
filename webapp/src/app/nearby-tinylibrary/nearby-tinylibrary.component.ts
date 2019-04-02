import{Component, OnDestroy, OnInit}from '@angular/core';
import {TinyLibraryService}from '../tinylibrary.service'
import {ActivatedRoute, Router}from '@angular/router';
import {Subscription}from 'rxjs';

@Component({
selector: 'app-nearby-tinylibrary',
templateUrl: './nearby-tinylibrary.component.html',
styleUrls: ['./nearby-tinylibrary.component.css']
})
export class NearbyTinylibraryComponent implements OnInit, OnDestroy {
nearByTinyLibrary: Array < any>;
latitude: number = 34.0522;      //Default: Los Angeles
longitude: number = -118.2437;   //Default: Los Angeles
zoom: number = 17;

sub: Subscription;

constructor(private route: ActivatedRoute,
    private router: Router, private tinylibraryservice: TinyLibraryService) { }

  ngOnInit() {
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(position => {
        this.latitude = position.coords.latitude;
        this.longitude = position.coords.longitude;

        this.sub = this.tinylibraryservice.getNearbyTinyLibraries(position.coords.latitude, position.coords.longitude, 10, "M").subscribe(s => {
          this.nearByTinyLibrary = s;
        });
      });
    } else {
      alert("Browser doesn't support geolocation");
    }
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  onRowClicked(tinylibrary: any) {
    this.router.navigate(['/library', tinylibrary.objectIDHexString]);
  }

  onMaxDistanceChange(event: any) {
    this.sub = this.tinylibraryservice.getNearbyTinyLibraries(this.latitude, this.longitude, event.value, "M").subscribe(s => {
      this.nearByTinyLibrary = s;
    });
  }
}
