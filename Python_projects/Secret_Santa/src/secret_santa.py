import json
import random


def read_file(file_name) -> dict[str, str]:
    with open(file_name) as f:
        return json.load(f)


def generate_pairs(persons: list[str]):
    persons_shuffled = persons.copy()
    random.shuffle(persons_shuffled)
    return {person: persons_shuffled[(idx + 1) % len(persons_shuffled)] for idx, person in enumerate(persons_shuffled)}


def write_to_file(file, pairings):
    with open(file, "w") as f:
        json.dump(pairings, f)


def main(filename):
    persons = read_file("folks.txt")
    pairings = generate_pairs(list(persons))
    write_to_file(filename, pairings)


main("secret_santa.txt")
