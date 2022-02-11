$(function() {
	let $grid = $('.row').masonry({
		itemSelector: '.image',
		percentPosition: true,
		stagger: 30,
		visibleStyle: { transform: 'translateY(0)', opacity: 1 },
		hiddenStyle: { transform: 'translateY(100px)', opacity: 0 },
	});

	var msnry = $grid.data('masonry');

	$grid.infiniteScroll({
		path: function() {
			return `/api/images?page=${this.pageIndex}`;
		},
		responseBody: 'json',
		outlayer: msnry,
		status: '.page-load-status',
		history: false,
	});

	$grid.on('load.infiniteScroll', function(event, body) {
		let itemsHTML = body.map(getItemHTML).join('');
		let $items = $(itemsHTML);
		$items.imagesLoaded(function() {
			$grid.append($items).masonry('appended', $items);
		})
	});

	$grid.infiniteScroll('loadNextPage');

	function getItemHTML({ name, url }) {
		return `<div class="image col-sm-6 col-lg-4 mb-4" style="position: absolute; left: 66.6667%; top: 0px;">
      <div class="card">
        <img src="${url}" alt="${name}" />

        <div class="card-body">
          <h5 class="card-title">${name}</h5>
          <p class="card-text">${name}.</p>
          <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
        </div>
      </div>
    </div>`;
	}

});