//
//  CustomCameraView.swift
//  Project2_1
//
//  Created by Michael Pardi on 4/3/17.
//  Copyright © 2017 MichaelPardi. All rights reserved.
//

import UIKit
import CoreMotion


class CustomCameraView: UIView {
    
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        isOpaque = false
        backgroundColor = UIColor.clear
        let timer = Timer.scheduledTimer(timeInterval: 1.0/30.0, target: self, selector: #selector(CustomCameraView.update), userInfo: nil, repeats: true)
        RunLoop.current.add(timer, forMode: RunLoopMode.defaultRunLoopMode)
    }
    
    required init?(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    func update() {
        setNeedsDisplay()
    }
    
}
