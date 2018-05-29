//
//  NewNoteViewController.swift
//  Project One
//
//  Created by Michael Pardi on 3/14/17.
//  Copyright © 2017 MichaelPardi. All rights reserved.
//

import UIKit
import CoreData

class NewNoteViewController: UIViewController, UITextViewDelegate {
    var newNote = NotesStore.sharedInstance
    
    @IBOutlet weak var noteField: UITextView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        navigationItem.rightBarButtonItem = UIBarButtonItem(title: "Save", style: .plain, target: self, action: #selector(saveNote)
        )
        
    }
    
    override func viewWillAppear(_ animated: Bool) {

    }
    
    func saveNote() {
        
        let alert = UIAlertController(title: "Save Note", message: "Please enter a file name", preferredStyle: .alert)
        
        alert.addTextField { (textField) in
        }
        
        alert.addAction(UIAlertAction(title: "Save", style: .default, handler: { [weak alert] (_) in
            let textField = alert?.textFields![0]
            self.newNote.title = textField?.text
            self.newNote.text = self.noteField.text
            self.newNote.createNote()
            
            }
        ))
        
        alert.addAction(UIAlertAction(title: "Cancel", style: .cancel, handler: nil))
        
        self.present(alert, animated: true, completion: nil)
        
    }
}
