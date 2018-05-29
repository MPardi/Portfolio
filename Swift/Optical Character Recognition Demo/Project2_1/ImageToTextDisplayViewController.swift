//
//  ImageToTextDisplayViewController.swift
//  Project2_1
//
//  Created by Michael Pardi on 4/5/17.
//  Copyright © 2017 MichaelPardi. All rights reserved.
//

import UIKit

class ImageToTextDisplayViewController: UIViewController {
    
    let colors = Colors()
    
    var ocrString = ""

    @IBOutlet weak var textView: UITextView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        refresh()
        
        textView.text = ocrString
        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func refresh() {
        view.backgroundColor = UIColor.clear
        let backgroundLayer = colors.gl
        backgroundLayer.frame = view.frame
        view.layer.insertSublayer(backgroundLayer, at: 0)
    }
}
