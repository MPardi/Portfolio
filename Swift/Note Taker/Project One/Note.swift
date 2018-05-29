//
//  Note.swift
//  Project One
//
//  Created by Michael Pardi on 3/14/17.
//  Copyright © 2017 MichaelPardi. All rights reserved.
//

import UIKit

class Note: NSObject, NSCoding {
    var title: String
    var text: String
    
    init(title: String, text: String) {
        self.title = title
        self.text = text
    }
    
    convenience required init(coder aDecoder: NSCoder) {
        let title = aDecoder.decodeObject(forKey: "title") as! String
        let text = aDecoder.decodeObject(forKey: "text") as! String
        self.init(title: title, text: text)
    }
    
    func encode(with aCoder: NSCoder) {
        aCoder.encode(title, forKey: "title")
        aCoder.encode(text, forKey: "text")
    }
}
