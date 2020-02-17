# Note Making App

User can create and view notes

## Prerequisites

Android Studio

### Getting Started

1. List Notes Screen

This is the home screen. When it launches, list all the notes the user has created in reverse chronological order (latest created note first).
This screen must contain an action (either a button or an action bar menu option) that opens screen 2. Tapping on a note should open Note Detail Screen.


2. Create Note Screen

Show the following text fields along with a button to “Save” the note:
Title: Free text, max 100 characters
Content: Free text, no limit
The only validation on these fields is that they must not be blank. 
The user must be able to enter values for both these fields. 
Hitting the “Save” button should save the note and take the user to Note Detail Screen.

![Add notes screen](screenshots/addnote.jpg =100x20)

3. Note Detail Screen

Show the note title and content, along with the timestamp when the note was created (ex: ’13 January 2018, 5:30 PM’).
This screen does not have any interaction and just displays static content.
If the user has arrived on this screen after immediately creating a note, pressing back on this screen should take them to List of notes screen.




