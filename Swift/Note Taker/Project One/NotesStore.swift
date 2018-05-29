//
//  NotesStore.swift
//  Project One
//
//  Created by Michael Pardi on 3/14/17.
//  Copyright © 2017 MichaelPardi. All rights reserved.
//

import UIKit
import Foundation

class NotesStore {
    
    static let sharedInstance = NotesStore()

    var allNotes = [Note]()
    
//    var newNote: Note
    
    var title: String!
    var text: String!
    
//    init(title: String, text: String) {
//        newNote = Note(title: self.title, text: self.text)
//    }
//
//    convenience required init(coder aDecoder: NSCoder) {
//        let title = aDecoder.decodeObject(forKey: "title") as? String
//        let text = aDecoder.decodeObject(forKey: "text") as? String
//        self.init(title: title!, text: text!)
//    }
//    
//    func encode(with aCoder: NSCoder) {
//        aCoder.encode(title, forKey: "title")
//        aCoder.encode(text, forKey: "text")
//    }
    
    @discardableResult func createNote() -> Note {
        let newNote = Note(title: title, text: text)
        
        allNotes.append(newNote)
        
        return newNote
    }
    
    
    func removeNote(_ note: Note) {
        if let index = allNotes.index(of: note) {
            allNotes.remove(at: index)
        }
    }
    
}
