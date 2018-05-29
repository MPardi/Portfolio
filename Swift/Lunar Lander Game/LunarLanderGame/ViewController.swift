//
//  ViewController.swift
//  LunarLanderGame
//
//  Created by Michael Pardi on 11/21/16.
//  Copyright © 2016 Michael Pardi. All rights reserved.
//

import Cocoa
import SpriteKit

class ViewController: NSViewController {

    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
    
    override func viewWillAppear() {
        super.viewWillAppear()
        
        let spriteView = view as! SKView
        
        if let visibleFrame = view.window?.screen?.visibleFrame {
            let newFrame = NSRect(x: visibleFrame.origin.x, y: visibleFrame.origin.y + 200.0, width: visibleFrame.width, height: visibleFrame.height - 200.0)
            view.window?.setFrame(newFrame, display:true)
        }
        
        let hello = StartSplash(size: CGSize(width: view.frame.width, height:
            view.frame.height))
        spriteView.presentScene(hello)
    }


    override var representedObject: Any? {
        didSet {
        // Update the view, if already loaded.
        }
    }


}

