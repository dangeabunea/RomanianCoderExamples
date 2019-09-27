import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'http-interceptor-example';

  constructor(private http: HttpClient) {
  }

  ngOnInit(): void {

    // Executing 3 HTTP Requests

    this.http.get('http://jsonplaceholder.typicode.com/users')
      .subscribe(data => {
        console.log('Users');
        console.log(data);
      });

    this.http.get('http://jsonplaceholder.typicode.com/posts/2')
      .subscribe(data => {
        console.log('Posts');
        console.log(data);
      });

    this.http.get('http://jsonplaceholder.typicode.com/posts/2/comments')
      .subscribe(data => {
        console.log('Comments');
        console.log(data);
      });
  }
}
