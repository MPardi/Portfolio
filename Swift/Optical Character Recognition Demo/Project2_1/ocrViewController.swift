//
//  ocrViewController.swift
//  Project2_1
//
//  Created by Michael Pardi on 4/4/17.
//  Copyright © 2017 MichaelPardi. All rights reserved.
//

import UIKit
import TesseractOCR

class ocrViewController: UIViewController, G8TesseractDelegate {
    //This is a left over test OCR class, used for elements it contained.

//    @IBOutlet weak var textView: UITextView!
//    
//    var image: UIImage
//    
////    init(image: UIImage) {
////        self.image = image
////        
////        super.init(nibName: nil, bundle: nil)
////    }
////    
////    required init?(coder aDecoder: NSCoder) {
////        fatalError("init(coder:) has not been implemented")
////    }
//    
//    override func viewDidLoad() {
//        super.viewDidLoad()
//        
//        if let tessOcr = G8Tesseract(language: "eng") {
//            tessOcr.delegate = self
//            
//            tessOcr.image = image.g8_blackAndWhite()
//            
//            tessOcr.recognize()
//            
//            textView.text = tessOcr.recognizedText
//            
//        }
//        
//        
//    }
//    
//    func progressImageRecognition(for tesseract: G8Tesseract!) {
//        print("Image Recognition Progress: \(tesseract.progress)%")
//    }

}
