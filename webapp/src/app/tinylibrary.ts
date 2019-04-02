import{Location}from'./location';
import {Book} from './book';
export class Tinylibrary {
objectIDHexString: string = "";
name: string = "";
location = new Location();
books: Book[] = [];
}
