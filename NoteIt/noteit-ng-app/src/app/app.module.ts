import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { RouterModule, Routes} from "@angular/router";
import { NotesComponent } from './notes/notes.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { NotFoundComponent } from './not-found/not-found.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { NoteComponent } from './notes/note/note.component';
import { NoteMenuComponent } from './notes/note-menu/note-menu.component';
import { NotebookComponent } from './notes/notebook/notebook.component';
import { NavigationComponent } from './navigation/navigation.component';
import { NoteTextSearchPipe } from './notes/note-text-search.pipe';

const appRoutes: Routes = [
  {
    path: 'notes',
    component: NotesComponent
  },
  {
    path: 'feedback',
    component: FeedbackComponent
  },
  { path: '',
    redirectTo: '/notes',
    pathMatch: 'full'
  },
  { path: '**', component: NotFoundComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    NotesComponent,
    FeedbackComponent,
    NotFoundComponent,
    NoteComponent,
    NoteMenuComponent,
    NotebookComponent,
    NavigationComponent,
    NoteTextSearchPipe
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes, {enableTracing:true}),
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
