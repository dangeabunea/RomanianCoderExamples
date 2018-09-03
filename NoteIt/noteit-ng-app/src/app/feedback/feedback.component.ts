import {Component, Input, OnInit} from '@angular/core';
import {ApiService} from "../shared/api.service";

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent implements OnInit {
  model: FeedbackModel = {
    name: "",
    email: "",
    feedback: ""
  };

  constructor(private apiService: ApiService) {
  }

  ngOnInit() {
  }

  sendFeedback(): void {
    this.apiService.sendFeedback(this.model)
      .subscribe(
        res => {
        alert("Feedback was sent;");
        location.reload();
      },
        err => {
          alert("Error :(");
        });
  }
}

export interface FeedbackModel {
  name: string;
  email: string;
  feedback: string;
}
