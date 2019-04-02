import{Injectable}from'@angular/core';
import {HttpClient, HttpHeaders}from '@angular/common/http';
import {Observable}from 'rxjs/Observable';
import {Tinylibrary} from './tinylibrary';

const httpOptions = {
headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class TinyLibraryService {
  BASE_URL = 'http://localhost:8080/library';

  constructor(private http: HttpClient) { }

  getNearbyTinyLibraries(lat, lng, maxDistance, unit): Observable<any> {
    return this.http.get(this.BASE_URL + '/nearby' + '/?lat=' + lat + '&lng=' + lng + '&maxDistance=' + maxDistance + '&unit=' + unit);
  }

  getTinyLibrary(id: string): Observable<any> {
    return this.http.get(this.BASE_URL + '/?id=' + id);
  }

  addTinyLibrary(tinyLib: Tinylibrary){
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http
    .post(this.BASE_URL, JSON.stringify(tinyLib), httpOptions)
    .subscribe(data => { console.log("[TinyLibraryService-editTinyLibrary] POST request is successful ") },
      error => {
        console.log(error);
      });
  }

  editTinyLibrary(tinyLib: any) {
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http
      .put(this.BASE_URL, JSON.stringify(tinyLib), httpOptions)
      .subscribe(data => { console.log("[TinyLibraryService-editTinyLibrary] PUT request is successful ") },
        error => {
          console.log(error);
        });
  }

  deleteTinyLibrary(id: string) {
    return this.http.delete(this.BASE_URL + '/?id=' + id);
  }

  checkOutBookFromTinyLibrary(book: any, id: string) {
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http
      .put(this.BASE_URL + '/book/?id=' + id, JSON.stringify(book), httpOptions)
      .subscribe(data => { console.log("[TinyLibraryService-checkOutBookFromTinyLibrary] PUT request is successful ") },
        error => {
          console.log(error);
        });
  }

  checkInBooksFromTinyLibrary(books: any, id: string) {
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http
      .put(this.BASE_URL + '/books/?id=' + id, JSON.stringify(books), httpOptions)
      .subscribe(data => { console.log("[TinyLibraryService-checkInBooksFromTinyLibrary] PUT request is successful ") },
        error => {
          console.log(error);
        });
  }
}
