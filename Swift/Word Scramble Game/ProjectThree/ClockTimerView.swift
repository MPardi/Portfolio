//
//  ClockTimerView.swift
//  ProjectThree
//
//  Created by Michael Pardi on 5/5/17.
//  Copyright © 2017 MichaelPardi. All rights reserved.
//

import UIKit

class ClockTimerView: UILabel {
    
    required init(coder aDecoder:NSCoder) {
        fatalError("use init(frame:")
    }
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        self.backgroundColor = UIColor.clear
    }
    
    func setSeconds(seconds:Int) {
        self.text = String(format: " %02i : %02i", seconds/60, seconds % 60)
        
        self.font = FontGameDisplayBig
    }
}
