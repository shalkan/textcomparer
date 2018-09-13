let Diff = require('text-diff');

export default class TextComparer {
  static diff = new Diff();

  static compareText = (source, modified) => {
    let textDiff = TextComparer.diff.main(source, modified);
    let compareSource = '';
    let compareResult = '';
    textDiff.forEach(item => {
      if (item[0] == 0) {
        compareSource += item[1];
        compareResult += item[1];
      }
      else if (item[0] == -1) {
        compareSource += '<span style="background-color: #ff9494">' + item[1] + '</span>';
      }
      else {
        compareResult += '<span style="background-color: #8de3cb">' + item[1] + '</span>';
      }
    });
    return {
      sourceValue: compareSource,
      modifiedValue: compareResult
    }
  }
}