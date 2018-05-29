//
//  File.swift
//  Project2_1
//
//  Created by Michael Pardi on 4/5/17.
//  Copyright © 2017 MichaelPardi. All rights reserved.
//

import UIKit
import QuartzCore

class Colors {
    
    //This class gives gradient background to main menu.
    
    var gl = CAGradientLayer()
    
    init() {
        //200 75 75
        let colorTop = UIColor(red: 119.0 / 255.0, green: 186.0 / 255.0, blue: 115.0 / 255.0, alpha: 1.0).cgColor
        let colorBottom = UIColor(red: 2.0 / 255.0, green: 170.0 / 255.0, blue: 196.0 / 255.0, alpha: 1.0).cgColor

        self.gl = CAGradientLayer()
        self.gl.colors = [colorTop, colorBottom]
        self.gl.startPoint = CGPoint(x: 0.0, y: 0.0)
        self.gl.endPoint = CGPoint(x: 1.0, y: 1.0)
        self.gl.locations = [0.0, 1.0]
    }
}
