import {Pipe, PipeTransform} from '@angular/core';
import {Note} from "./model/note";

@Pipe({
  name: 'noteTextSearch',
  pure:false
})
export class NoteTextSearchPipe implements PipeTransform {

  transform(notes: Note[], args?: string): Note[] {
    if(!args){
      return notes;
    }
    return notes.filter(n => n.title.includes(args)
      || n.text.includes(args));
  }

}
