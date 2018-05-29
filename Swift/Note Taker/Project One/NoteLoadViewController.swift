//
//  NoteLoadViewController.swift
//  Project One
//
//  Created by Michael Pardi on 3/14/17.
//  Copyright © 2017 MichaelPardi. All rights reserved.
//

import UIKit

class NoteLoadViewController: UIViewController, UITextViewDelegate {
    
    @IBOutlet weak var noteField: UITextView!
    
    var note: Note?
    
    override func viewDidLoad() {
        super.viewDidLoad()

    }
    
    override func viewWillAppear(_ animated: Bool) {
        if let note = note {
            noteField.text = note.text
        }
        
        self.navigationItem.title = note?.title
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        dismiss(animated: true, completion: nil)
    }
    
}
