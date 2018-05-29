//
//  MenuViewController.swift
//  Project One
//
//  Created by Michael Pardi on 3/14/17.
//  Copyright © 2017 MichaelPardi. All rights reserved.
//

import UIKit
import Foundation

class MenuViewController: UIViewController {
    var notesStore = NotesStore.sharedInstance
//    var notesStore = NotesStore()
    
    let defaults = UserDefaults.standard
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    override func viewWillAppear(_ animated: Bool) {
        self.navigationController?.setNavigationBarHidden(true, animated: animated)
        self.navigationController?.setToolbarHidden(true, animated: animated)
        super.viewWillAppear(animated)
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        self.navigationController?.setNavigationBarHidden(false, animated: animated)
        super.viewWillDisappear(animated)
    }
}
