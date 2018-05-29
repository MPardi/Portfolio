//
//  Receipts+CoreDataProperties.swift
//  CSE335_ClassProject
//
//  Created by student on 3/30/18.
//  Copyright © 2018 Michael Pardi. All rights reserved.
//
//

import Foundation
import CoreData


extension Receipts {

    @nonobjc public class func fetchRequest() -> NSFetchRequest<Receipts> {
        return NSFetchRequest<Receipts>(entityName: "Receipts")
    }

    @NSManaged public var store: String?
    @NSManaged public var total: NSDecimalNumber?
    @NSManaged public var item: String?
    @NSManaged public var image: NSData?
    @NSManaged public var location: String?
}
