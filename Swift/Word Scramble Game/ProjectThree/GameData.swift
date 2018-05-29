//
//  GameData.swift
//  ProjectThree
//
//  Created by Michael Pardi on 5/5/17.
//  Copyright © 2017 MichaelPardi. All rights reserved.
//

class GameData {
    var points: Int = 0 {
        didSet {
            points = max(points, 0)
        }
    }
}
