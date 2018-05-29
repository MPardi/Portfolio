//
//  AudioController.swift
//  ProjectThree
//
//  Created by Michael Pardi on 5/5/17.
//  Copyright © 2017 MichaelPardi. All rights reserved.
//

import AVFoundation

class AudioController {
    var audio = [String: AVAudioPlayer]()
    
    func preloadAudioEffects(effectFileNames:[String]) {
        for effect in AudioEffectFiles {
            do {
                var soundURL = URL.init(fileURLWithPath: Bundle.main.resourcePath!);
                try soundURL.appendPathComponent(effect)
                
                let player = try AVAudioPlayer(contentsOf: soundURL)
                
                player.numberOfLoops = 0
                player.prepareToPlay()
                
                audio[effect] = player
            } catch {
                assert(false, "Load sound failed")
            }
        }
    }
    
    func playEffect(name:String) {
        if let player = audio[name] {
            if player.isPlaying {
                player.currentTime = 0
            } else {
                player.play()
            }
        }
    }
}
