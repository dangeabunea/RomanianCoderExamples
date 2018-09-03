import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {Notebook} from "./model/notebook";
import {ApiService} from "../shared/api.service";
import {Note} from "./model/note";

@Component({
  selector: 'app-notes',
  templateUrl: './notes.component.html',
  styleUrls: ['./notes.component.css']
})
export class NotesComponent implements OnInit {
  notebooks: Notebook[] = [];
  selectedNotebook: Notebook = null;
  selectedNotebookNotes: Note[] = [];
  searchText: string = null;

  constructor(private apiService: ApiService) {
  }

  ngOnInit() {
    this.getAllNotebooks();
    this.getAllNotes();
  }

  getAllNotebooks() {
    this.apiService.getNotebooks().subscribe(
      res => {
        this.notebooks = res;
      },
      err => {
        alert("could not load notebooks")
      }
    );
  }

  getAllNotes() {
    this.apiService.getAllNotes().subscribe(
      res => {
        this.selectedNotebookNotes = res;
        this.selectedNotebook = null;
      },
      err => alert("could not load all notes")
    )
  }

  onNotebookDeleted(notebook: Notebook) {
    let index = this.notebooks.indexOf(notebook);
    this.notebooks.splice(index, 1);
    if (notebook == this.selectedNotebook) {
      this.getAllNotes();
    }
  }

  onNotebookSelected(notebookSelectedData: any) {
    this.selectedNotebook = notebookSelectedData.notebook;
    this.selectedNotebookNotes = notebookSelectedData.notes;
  }

  onNoteCreated(note: Note) {
    this.selectedNotebookNotes.push(note);
  }

  onNotebookCreated(notebook: Notebook) {
    this.notebooks.push(notebook);
  }

  onNoteDeleted(note: Note) {
    let noteIndex = this.selectedNotebookNotes.indexOf(note);
    this.selectedNotebookNotes.splice(noteIndex, 1);
  }

  onSearchTextChanged(newSearchText: string){
    this.searchText = newSearchText;
  }
}
