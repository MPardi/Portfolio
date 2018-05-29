//
//  LoadNoteViewController.swift
//  Project One
//
//  Created by Michael Pardi on 3/14/17.
//  Copyright © 2017 MichaelPardi. All rights reserved.
//

import UIKit

class LoadNoteViewController: UITableViewController {
    var notesStore = NotesStore.sharedInstance
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.navigationItem.title = "Load Note"
        self.navigationItem.rightBarButtonItem = self.editButtonItem
    }
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return NotesStore.sharedInstance.allNotes.count
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "Cell", for: indexPath)
        tableView.register(UITableViewCell.self, forCellReuseIdentifier: "Cell")
        
        let item = notesStore.allNotes[indexPath.row]
        
        cell.textLabel!.text = item.title
        
        return cell
    }
    
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCellEditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            let note = notesStore.allNotes[indexPath.row]
            
            notesStore.removeNote(note)
            
            tableView.deleteRows(at: [indexPath], with: .automatic)
        }
    }
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        performSegue(withIdentifier: "loadSegue", sender: nil)
    }
    
    override func viewWillAppear(_ animated: Bool) {
        self.navigationController?.setToolbarHidden(true, animated: false)
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if let row = tableView.indexPathForSelectedRow?.row {
            let note = notesStore.allNotes[row]
            
            let loadViewController = segue.destination as! NoteLoadViewController
            
            loadViewController.note = note
        }
    }
}
