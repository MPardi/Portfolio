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
        let colorTop = UIColor(red: 200.0 / 255.0, green: 75.0 / 255.0, blue: 75.0 / 255.0, alpha: 1.0).cgColor
        let colorBottom = UIColor(red: 231.0 / 255.0, green: 142.0 / 255.0, blue: 141.0 / 255.0, alpha: 1.0).cgColor
        
        self.gl = CAGradientLayer()
        self.gl.colors = [colorTop, colorBottom]
        self.gl.locations = [0.0, 1.0]
    }
}
