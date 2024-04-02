// Tianyi Huang
// A00315929

$(document).ready(function() {
    getBooks();
});

function getBooks() {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8081/Library/rest/books',
        dataType: 'json',
        success: function(books) {
            var bookList = $('#bookList');
            bookList.empty();
            books.forEach(function(book) {
                bookList.append(
                    '<tr>' +
                    '<td><img src="images/' + book.imageThumb + '" alt="' + book.title + '"></td>' +
                    '<td>' + book.title + ' By ' + book.author + '</td>' +
                    '<td><a href="#" data-id="' + book.id + '" class="moreInfoLink">More Info</a></td>' +
                    '</tr>'
                );
            });
            attachMoreInfoHandlers();
        },
        error: function() {
            $('#bookList').html('<tr><td colspan="3">Error fetching data.</td></tr>');
        }
    });
}

function attachMoreInfoHandlers() {
    $('.moreInfoLink').click(function(e) {
        e.preventDefault();
        var bookId = $(this).data('id');
        showBookDetails(bookId);
    });
}

function showBookDetails(bookId) {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8081/Library/rest/books/' + bookId,
        dataType: 'json',
        success: function(book) {
            var detailsSection = $('#details');
            detailsSection.empty();
            var publisherURL = 'https://' + book.publisherURL;
            var content =
                '<h3>' + book.title + '</h3>' +
                '<p>' + book.review + '</p>' +
                '<p><a href="' + publisherURL + '" target="_blank">' + book.publisher + '</a></p>' +

                '<p><a href="#" onclick="showBookImage(\'' + book.image + '\')">Show Image</a></p>';
            detailsSection.append(content);
        },
        error: function() {
            $('#details').html('<p>Error fetching details.</p>');
        }
    });
}


function showBookImage(imageFileName) {
    var detailsSection = $('#details');
    detailsSection.empty();
    detailsSection.append('<img src="images/' + imageFileName + '" alt="Book cover" />');
}


