import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Notebook} from "../model/notebook";
import {ApiService} from "../../shared/api.service";

@Component({
  selector: 'app-notebook',
  templateUrl: './notebook.component.html',
  styleUrls: ['./notebook.component.css']
})
export class NotebookComponent implements OnInit {
  @Input() notebook: Notebook;
  @Output() onNotebookUpdated: EventEmitter<Notebook> = new EventEmitter();
  @Output() onNotebookDeleted: EventEmitter<Notebook> = new EventEmitter();
  @Output() onNotebookSelected: EventEmitter<any> = new EventEmitter();

  constructor(private apiService: ApiService) {
  }

  ngOnInit() {
  }

  updateNotebook() {
    this.apiService.createOrUpdateNotebook(this.notebook).subscribe(
      res => {
        this.onNotebookUpdated.emit(this.notebook);
      },
      err => {
        alert("Could not create/update notebook");
      }
    );
  }

  deleteNotebook() {
    if (confirm("Are you sure? All notes will be lost")) {
      this.apiService.deleteNotebook(this.notebook.id).subscribe(
        res => {
          this.onNotebookDeleted.emit(this.notebook);
        },
        err => {
          "Error deleting notebook"
        }
      );
    }
  }

  getNotesInNotebook() {
    this.apiService.getNotesByNotebookId(this.notebook.id).subscribe(
      res => {
        this.onNotebookSelected.emit({
          notebook: this.notebook,
          notes: res
        });
      },
      err => {
        "Could not grab notes for notebook"
      }
    );
  }
}
