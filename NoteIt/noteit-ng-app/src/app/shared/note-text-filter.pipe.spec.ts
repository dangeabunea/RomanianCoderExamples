import {NoteTextFilterPipe} from './note-text-filter.pipe';
import {Note} from "../notes/model/note";

describe('NoteTextFilterPipe', () => {
  it('create an instance', () => {
    const pipe = new NoteTextFilterPipe();
    expect(pipe).toBeTruthy();
  });

  it('should not filter notes if search text is empty', ()=>{
    // arrange
    let pipe = new NoteTextFilterPipe();
    let emptySearchText = "";
    let notes:Note[] = [
      {id:'1', title:'title1',text:'text1',notebookId:'10', lastModifiedOn:''},
      {id:'2', title:'title2',text:'text2',notebookId:'10', lastModifiedOn:''}
    ];

    // act
    let filteredNotes = pipe.transform(notes, emptySearchText);

    // assert
    expect(filteredNotes.length).toBe(2);
  });

  it('should filter notes based on search text', ()=>{
    // arrange
    let pipe = new NoteTextFilterPipe();
    let searchText = "text2";
    let notes:Note[] = [
      {id:'1', title:'title1',text:'text1',notebookId:'10', lastModifiedOn:''},
      {id:'2', title:'title2',text:'text2',notebookId:'10', lastModifiedOn:''}
    ];

    // act
    let filteredNotes = pipe.transform(notes, searchText);

    // assert
    expect(filteredNotes.length).toBe(1);
    expect(filteredNotes[0].id).toBe('2');
  });
});
