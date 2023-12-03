import os.path
import string
import random
import sys
import pytest

from Secret_Santa.secret_santa import read_file, generate_pairs, write_to_file, main


@pytest.fixture
def persons():
    return [generate_strings(), generate_strings(), generate_strings()]


@pytest.fixture
def pairings(persons):
    return {persons[0]: persons[1]}


def generate_strings():
    letters = string.ascii_lowercase
    return ''.join(random.choices(letters, k=5))


def test_main_should_output_file_with_pairings():
    main("secret_santa.txt")
    assert os.path.exists("secret_santa.txt")


@pytest.fixture
def mock_shuffle(monkeypatch):

    def shuffle(*args, **kwargs):
        pass

    monkeypatch.setattr(random, "shuffle", shuffle)


def test_that_generate_pairings_has_called_random_shuffle(mock_shuffle):
    lista = [1, 2, 3, 4]
    random.shuffle(lista)
    print(lista, file=sys.stderr)


def test_main_should_output_a_different_pairings_every_run(persons):
    pairs1 = generate_pairs(persons)
    pairs2 = generate_pairs(persons)
    assert pairs1 != pairs2


def test_read_file():
    persons = read_file("folks.txt")
    assert persons == {"sarah": "haras", "haras": "sofia", "sofia": "sarah"}


def test_generate_pairs_should_not_pair_with_self(persons):
    pairs = generate_pairs(persons)
    for person in persons:
        assert pairs[person] != person


def test_generate_pairs_should_pair_with_person(persons):
    pairs = generate_pairs(persons)
    for person in persons:
        assert pairs[person] in persons


def test_generate_pairs_should_pair_one_to_one(persons):
    pairs = generate_pairs(persons)
    assert len(set(pairs)) == len(set(pairs.values()))


def test_generate_pairs_should_pair_with_next_person_after_shuffle(mock_shuffle):
    persons = ["a", "b", "c"]
    pairs = generate_pairs(persons)
    assert pairs == {"a": "b", "b": "c", "c": "a"}


def test_write_to_file_should_create_file(tmp_path):
    file = tmp_path / "pairings.txt"
    write_to_file(file, {})
    assert os.path.exists(file)


def test_read_file_returns_write_file_parameter(tmp_path, pairings):
    file = tmp_path / "pairings.txt"
    write_to_file(file, pairings)
    assert read_file(file) == pairings


def test_generate_strings():
    random_string = generate_strings()
    assert type(random_string) == str
    assert len(random_string) > 3
