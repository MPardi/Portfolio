//
//  OCRAttempt.swift
//  Project2_1
//
//  Created by Michael Pardi on 4/5/17.
//  Copyright © 2017 MichaelPardi. All rights reserved.
//

import TesseractOCR

class OCRAttempt: NSObject, G8TesseractDelegate {
    
    var image: UIImage? = nil
    
    //Initializes image value.
    init(image: UIImage) {
        super.init()
        
        self.image = image
        
//        process()
    }
    
    func process() -> String {
        var result: String = ""
        
        //If english is available
        if let tessOcr = G8Tesseract(language: "eng") {
            
            tessOcr.delegate = self
            
            //Puts image through process.
            tessOcr.image = image?.g8_blackAndWhite()
            
            //Runs recognition
            tessOcr.recognize()
            
//            textView.text = tessOcr.recognizedText
            
            //Get recognized text.
            result = tessOcr.recognizedText
            
        }
        return result
    }
    
    
    //Tried to implement progress bar, as it can take a bit to analyze images, but not enough time.
//    func progressImageRecognition(for tesseract: G8Tesseract!) -> UInt {
//        return tesseract.progress
//    }
}
