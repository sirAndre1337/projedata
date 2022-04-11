export type ProductsResponse = {
    content: Product[];
    totalPages: number;
}

export type FeedstocksResponse = {
    content: Feedstock[];
    totalPages: number;
}

// export type AmountFeedStockReponse = {
//     content : AmountFeedstocks[];
// }

export type Product = {
    id: number;
    name: string;
    price: number;
}

export type Feedstock = {
     id: number;
     name: string;
     amount: number;
     type: string;
}

export type AmountFeedstocks = {
    id: number
    feedstock_id: number;
    product_id: number;
    amount: number;
}