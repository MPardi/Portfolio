//
//  Level.swift
//  ProjectThree
//
//  Created by Michael Pardi on 5/4/17.
//  Copyright © 2017 MichaelPardi. All rights reserved.
//

import Foundation

class Level {
    let pointsPerTile: Int
    let levelTime: Int
    
    init() {
        let fileName = "LevelProperties.plist"
        let levelPath = "\(Bundle.main.resourcePath!)/\(fileName)"
        
        let levelDictionary: NSDictionary? = NSDictionary(contentsOfFile: levelPath)
        
        assert(levelDictionary != nil, "Level configuration file not found")
        
        self.pointsPerTile = levelDictionary!["pointsPerTile"] as! Int
        self.levelTime = levelDictionary!["levelTime"] as! Int
    }
}

//var pointsPerTile: Int
//var levelTime: Int
//
//init() {
//    //1 find .plist file for this level
//    let fileName = "levelProperties.plist"
//    let levelPath = "\(Bundle.main.resourcePath!)/\(fileName)"
//    
//    //2 load .plist file
//    let levelDictionary: NSDictionary? = NSDictionary(contentsOfFile: levelPath)
//    
//    //3 validation
//    assert(levelDictionary != nil, "Level configuration file not found")
//    
//    //4 initialize the object from the dictionary
//    self.pointsPerTile = levelDictionary!["pointsPerTile"] as! Int
//    self.levelTime = levelDictionary!["levelTime"] as! Int
//}
