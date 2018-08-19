import {Component, Input, OnInit} from '@angular/core';
import {FeedbackService} from "./feedback.service";

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

  constructor(private feedbackService: FeedbackService) {
  }

  ngOnInit() {
  }

  sendFeedback(): void {
    this.feedbackService.sendFeedback(this.model)
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
