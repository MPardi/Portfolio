//
//  ScoreView.swift
//  ProjectThree
//
//  Created by Michael Pardi on 5/5/17.
//  Copyright © 2017 MichaelPardi. All rights reserved.
//

import UIKit

class ScoreView: UILabel {
    var endValue: Int = 0
    var timer: Timer? = nil
    
    var value: Int = 0 {
        didSet {
            self.text = " \(value)"
        }
    }
    
    required init(coder aDecoder: NSCoder) {
        fatalError("Use init(font: ,frame: )")
    }
    
    init(font: UIFont, frame: CGRect) {
        super.init(frame: frame)
        
        self.font = font
        self.backgroundColor = UIColor.clear
    }
    
    func updateValue(timer: Timer) {
        if endValue < value {
            value -= 1
        }
        else {
            value += 1
        }
        
        if endValue == value {
            timer.invalidate()
            self.timer = nil
        }
    }
    
    func setValue(newValue: Int, duration: Float) {
        endValue = newValue
        
        if timer != nil {
            timer?.invalidate()
            timer = nil
        }
        
        let deltaValue = abs(endValue - value)
        if deltaValue != 0 {
            var interval = Double(duration / Float(deltaValue))
            if interval < 0.01 {
                interval = 0.01
            }
            
            timer = Timer.scheduledTimer(timeInterval: interval, target: self, selector: #selector(ScoreView.updateValue(timer:)), userInfo: nil, repeats: true)
        }
    }

}
