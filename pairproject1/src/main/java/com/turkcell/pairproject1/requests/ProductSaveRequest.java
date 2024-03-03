package com.turkcell.pairproject1.requests;

import com.turkcell.pairproject1.entities.Category;

public record ProductSaveRequest(int id,
                                 String name,
                                 double unitPrice,
                                 int stock,
                                 String description,
                                 String photoUrl,
                                 Category category) {
}
