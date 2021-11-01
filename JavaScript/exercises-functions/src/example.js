var {
  testCase,
  assert,
  assertEquals,
  asyncTest
} = require('./test-runner');

/**
* DESCRIPTION:
* Replace all occurrences of 'REPLACE_ME' in the unit tests below to make them
* all pass (they should be green).
* HINT
* If you get stuck, you can replace assert(a == b) with assertEquals(b, a).
* That way the error message in the browser will be more specific. However,
* give it a try before you do this, as in most cases this will give you the
* answer flat out.
*/
var REPLACE_ME = '...';

testCase('Variables', {
  'Sync test': function() {
    // Fill in necessary statement(s) to pass the assertions below
    var a = 23;

    assertEquals(a, 23);
  },

  'Another Sync test': function() {
    // Fill in necessary statement(s) to pass the assertions below
    var a = 23;

    assertEquals(a, 23);
  },

  'Async test': function(done) {
    /**
     * Call this function at the end
     * of the implementation
     */
    function completed(err, result) {
      asyncTest(function() {
        assert(err == REPLACE_ME);
        assert(result == REPLACE_ME);
        assert(true);
      }, done);
    }

    /**
     * Do your implementation here
     */
    setTimeout(function() {
      completed(null, 'hello');
    }, 1000);
  },
});
