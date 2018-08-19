import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { RouterModule, Routes} from "@angular/router";
import { NotesComponent } from './notes/notes.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { NotFoundComponent } from './not-found/not-found.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";

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
    NotFoundComponent
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
