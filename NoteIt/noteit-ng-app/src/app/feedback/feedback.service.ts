import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {FeedbackModel} from "./feedback.component";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {
  private feedbackUrl = "http://localhost:8080/api/feedback";

  constructor(private http: HttpClient) {
  }

  sendFeedback(feedbackModel: FeedbackModel): Observable<any> {
    let request = this.http.post(this.feedbackUrl, feedbackModel);

    return request;
  }
}
