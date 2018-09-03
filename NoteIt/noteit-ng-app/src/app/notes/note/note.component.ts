import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Note} from "../model/note";
import {ApiService} from "../../shared/api.service";

@Component({
  selector: 'app-note',
  templateUrl: './note.component.html',
  styleUrls: ['./note.component.css']
})
export class NoteComponent implements OnInit {
  @Input() note: Note;
  @Output() onNoteDeleted: EventEmitter<Note> = new EventEmitter();
  @Output() onNoteUpdated: EventEmitter<Note> = new EventEmitter();

  constructor(private apiService: ApiService) {
  }

  ngOnInit() {
  }

  updateNote() {
    this.apiService.createOrUpdateNote(this.note).subscribe(
      res => {
        this.onNoteUpdated.emit(this.note);
      },
      err => {
        alert("cold not update note")
      }
    );
  }

  delete() {
    if (confirm("Are you sure you want to delete the note?")) {
      this.apiService.deleteNote(this.note.id).subscribe(
        res => {
          this.onNoteDeleted.emit(this.note);
        },
        err => {
          alert("could not delete note")
        }
      );

    }
  }

}
