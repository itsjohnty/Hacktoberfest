from art import logo
import os

print(logo)

bidders = {}
bidding_finished = False

def find_highest_bidder(bid_record):
    highest_bid = 0
    winner_name = ""
    for bidder_name in bid_record:
        bid_amount = bid_record[bidder_name]
        if bid_amount > highest_bid:
            highest_bid = bid_amount
            winner_name = bidder_name
    print(f"The winner is {winner_name} with a bid of ${highest_bid}")

while not bidding_finished:
    bidder_name = input("What is your name? ")
    bid_amount = int(input("Enter the bid price $"))
    bidders[bidder_name] = bid_amount
    continue_bidding = input("Are there any other bidders? Type 'yes' or 'no': ")
    os.system('cls')  # Clear the console
    if continue_bidding == "no":
        bidding_finished = True
        find_highest_bidder(bidders)