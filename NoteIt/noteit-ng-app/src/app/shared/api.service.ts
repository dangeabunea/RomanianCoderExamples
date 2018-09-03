import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Notebook} from "../notes/model/notebook";
import {Note} from "../notes/model/note";
import {FeedbackModel} from "../feedback/feedback.component";

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private baseHref = "http://localhost:8082/api";
  private allNotebooksUrl = `${this.baseHref}/notebooks/all`;
  private allNotesUrl = `${this.baseHref}/notes/all`;
  private notesByNotebookIdUrl = `${this.baseHref}/notes/byNotebook/`;
  private feedbackUrl = `${this.baseHref}/feedback/`;
  private createUpdateNotebookUrl = `${this.baseHref}/notebooks`;
  private deleteNotebookUrl = `${this.baseHref}/notebooks/`;
  private createUpdateNoteUrl = `${this.baseHref}/notes`;
  private deleteNoteUrl = `${this.baseHref}/notes/`;

  constructor(private http: HttpClient) {
  }

  getNotebooks(): Observable<Notebook[]> {
    return this.http.get<Notebook[]>(this.allNotebooksUrl);
  }

  getNotesByNotebookId(notebookId: string): Observable<Note[]> {
    return this.http.get<Note[]>(this.notesByNotebookIdUrl + notebookId);
  }

  sendFeedback(feedbackModel: FeedbackModel): Observable<any> {
    return this.http.post(this.feedbackUrl, feedbackModel);
  }

  createOrUpdateNotebook(notebook: Notebook) {
    return this.http.post<Notebook>(this.createUpdateNotebookUrl, notebook);
  }

  deleteNotebook(id: string) {
    return this.http.delete(this.deleteNotebookUrl + id);
  }

  createOrUpdateNote(note: Note) {
    return this.http.post<Note>(this.createUpdateNoteUrl, note);
  }

  deleteNote(id: string) {
    return this.http.delete(this.deleteNoteUrl + id);
  }

  getAllNotes(): Observable<Note[]> {
    return this.http.get<Note[]>(this.allNotesUrl);
  }

}
