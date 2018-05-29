//
//  ReceiptTableViewCell.swift
//  CSE335_ClassProject
//
//  Created by student on 3/30/18.
//  Copyright © 2018 Michael Pardi. All rights reserved.
//

import UIKit

class ReceiptTableViewCell: UITableViewCell {
    
    @IBOutlet weak var receiptItem: UILabel!
    @IBOutlet weak var receiptImage: UIImageView! {
        didSet {
            receiptImage.layer.cornerRadius = 5
            receiptImage.clipsToBounds = true
        }
    }
    @IBOutlet weak var receiptTotal: UILabel!
    @IBOutlet weak var receiptStore: UILabel!
    @IBOutlet weak var receiptLocation: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }

}
