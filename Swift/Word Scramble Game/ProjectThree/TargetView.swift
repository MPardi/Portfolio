//
//  TargetView.swift
//  ProjectThree
//
//  Created by Michael Pardi on 5/4/17.
//  Copyright © 2017 MichaelPardi. All rights reserved.
//

import UIKit

class TargetView: UIImageView {
    var isMatched: Bool = false
    
    required init(coder aDecoder: NSCoder) {
        fatalError("sideLength: ")
    }
    
    init() {
        
        let image = UIImage(named: "slot")!.alpha(0.5)
        
        super.init(image: image)
        
        let scale: CGFloat = 1.0
        
        self.frame = CGRect(x: 0, y: 0, width: image.size.width * scale, height: image.size.height * scale)
    }
}

extension UIImage{
    
    func alpha(_ value:CGFloat)->UIImage
    {
        UIGraphicsBeginImageContextWithOptions(size, false, scale)
        draw(at: CGPoint.zero, blendMode: .normal, alpha: value)
        let newImage = UIGraphicsGetImageFromCurrentImageContext()
        UIGraphicsEndImageContext()
        return newImage!
        
    }
}
