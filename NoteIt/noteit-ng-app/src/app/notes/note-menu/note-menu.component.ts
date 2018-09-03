import {ChangeDetectionStrategy, Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {ApiService} from "../../shared/api.service";
import {Note} from "../model/note";
import {Notebook} from "../model/notebook";

@Component({
  selector: 'app-note-menu',
  templateUrl: './note-menu.component.html',
  styleUrls: ['./note-menu.component.css']
})
export class NoteMenuComponent implements OnInit {
  @Input() selectedNotebook: Notebook;
  @Input() searchText: string;
  @Output() onNoteCreated: EventEmitter<Note> = new EventEmitter();
  @Output() onNotebookCreated: EventEmitter<Notebook> = new EventEmitter();
  @Output() onSearchTextChanged: EventEmitter<string> = new EventEmitter();

  constructor(private apiService: ApiService) {
  }

  ngOnInit() {
  }

  createNewNote() {
    let note = {id: null, title: "New note", text: "Add text here", notebookId: this.selectedNotebook.id};
    this.apiService.createOrUpdateNote(note).subscribe(
      res => {
        this.onNoteCreated.emit(res);
      },
      err => {
        alert("could note create/update note")
      }
    );
  }

  changeSearchText(newSearchText: string) {
    this.onSearchTextChanged.emit(this.searchText);
  }

  createNewNotebook() {
    let notebook = {name: "New notebook", nbOfNotes: 0, id: null};
    this.apiService.createOrUpdateNotebook(notebook).subscribe(
      res => {
        this.onNotebookCreated.emit(res);
      },
      err => {
        alert("Could not create/update notebook");
      }
    );

  }
}
