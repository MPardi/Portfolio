//
//  Users+CoreDataClass.swift
//  CSE335_ClassProject
//
//  Created by student on 3/30/18.
//  Copyright © 2018 Michael Pardi. All rights reserved.
//
//

import Foundation
import CoreData

public class Users: NSManagedObject {
    var receipts: [Receipts] = []
}
